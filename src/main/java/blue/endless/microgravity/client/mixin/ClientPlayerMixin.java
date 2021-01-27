package blue.endless.microgravity.client.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerMixin extends AbstractClientPlayerEntity {
	@Shadow
	private double lastX;
	@Shadow
	private double lastBaseY;
	@Shadow
	private double lastZ;
	
	public ClientPlayerMixin(ClientWorld world, GameProfile profile) {
		super(world, profile);
	}

	private Vec3d storedPos;
	private Vec3d storedVelocity;
	
	@Inject(at = @At("HEAD"), method = "tick()V")
	public void tickBefore(CallbackInfo info) {
		if (world!=null) {
			//snapshot pos and velocity so that we can restore them later if needed
			storedPos = getPos();
			storedVelocity = getVelocity();
		}
	}
	
	@Inject(at = @At(value = "INVOKE", target = "sendMovementPackets()V"), method = "tick()V")
	public void tickDuring(CallbackInfo info) {
		if (storedPos!=null && storedVelocity!=null) {
			//Vec3d delta = getPos().subtract(storedPos);
			//System.out.println("Delta position: "+delta);
			
			this.setPos(storedPos.x, storedPos.y, storedPos.z);
			
			this.prevX = storedPos.x;
			this.prevY = storedPos.y;
			this.prevZ = storedPos.z;
			this.lastRenderX = storedPos.x;
			this.lastRenderY = storedPos.y;
			this.lastRenderZ = storedPos.z;
			this.lastX = storedPos.x;
			this.lastBaseY = storedPos.y;
			this.lastZ = storedPos.z;
			
			this.fallDistance = 0f;
			
			this.upwardSpeed = 0f;
			this.horizontalSpeed = 0f;
			
			this.updatePosition(storedPos.x, storedPos.y, storedPos.z);
			this.setVelocity(0, 0, 0);
		}
		storedPos = null;
		storedVelocity = null;
	}
}
