/*MIT License

Copyright (c) 2021 Marko Dujović

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

package com.codenamerevy.magicmirror.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("ALL")
public class MirrorParticle extends SpriteTexturedParticle
{
    private static final Random RAND = new Random();
    protected final IAnimatedSprite animatedSprite;

    private MirrorParticle(IAnimatedSprite animatedSprite, ClientWorld world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, 0.5D - RAND.nextDouble(), speedY, 0.5D - RAND.nextDouble());
        this.animatedSprite = animatedSprite;
        this.motionY *= 0.15D;
        if(speedX == 0.0D && speedZ == 0.0D) {
            this.motionX *= 0.5D;
            this.motionZ *= 0.5D;
        }
        this.particleScale *= 0.3F;
        this.maxAge = (int)(7.5D / (Math.random() * 0.2D + 0.1D)); //was 7.5 0.4 and 0.2
        this.canCollide = false;
        this.selectSpriteWithAge(animatedSprite);
    }

    public void tick()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if(this.age++ >= this.maxAge){
            this.setExpired();
        }else{
            this.selectSpriteWithAge(this.animatedSprite);
            this.motionY += 0.04D;
            this.move(this.motionX, this.motionY, this.motionZ);
            if(this.posY == this.prevPosY){
                this.motionX *= 0.5D;
                this.motionZ *= 0.5D;
            }
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
            if (this.onGround) {
                this.motionX *= 0.5D;
                this.motionZ *= 0.5D;
            }
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getBrightnessForRender(float partialTick) {
        float f = ((float) this.age + partialTick) / (float) this.maxAge;
        f = MathHelper.clamp(f, 0f, 1f);
        int i = super.getBrightnessForRender(partialTick);
        int j = i & 255;
        int k = i >> 16 & 255;
        j = j + (int) (f * 15f * 16f);
        if (j > 240) {
            j = 240;
        }
        return j | k << 16;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite animatedSprite;

        public Factory(IAnimatedSprite animatedSprite) {
            this.animatedSprite = animatedSprite;
        }

        @Nullable
        @Override
        public Particle makeParticle(BasicParticleType type, ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new MirrorParticle(this.animatedSprite, world, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
