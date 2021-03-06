package net.ilexiconn.lawnmower.client.sound;

import net.ilexiconn.lawnmower.client.ClientProxy;
import net.ilexiconn.lawnmower.server.entity.LawnmowerEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RustleSound extends MovingSound {
    private LawnmowerEntity entity;

    public RustleSound(LawnmowerEntity entity) {
        super(ClientProxy.RUSTLE, SoundCategory.AMBIENT);
        this.entity = entity;
        this.repeat = true;
        this.repeatDelay = 1;
        this.volume = 2.0F;
    }

    @Override
    public void update() {
        if (this.entity.isDead) {
            this.donePlaying = true;
            this.volume = 0.0F;
            return;
        }

        this.xPosF = (float) this.entity.posX;
        this.yPosF = (float) this.entity.posY;
        this.zPosF = (float) this.entity.posZ;
    }
}
