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

	private Vec3d microgravity_storedPos;
	private Vec3d microgravity_storedVelocity;
	
	@Inject(at = @At("HEAD"), method = "tick()V")
	public void tickBefore(CallbackInfo info) {
		if (world!=null) {
			//snapshot pos and velocity so that we can restore them later if needed
			microgravity_storedPos = getPos();
			microgravity_storedVelocity = getVelocity();
		}
	}
	
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;sendMovementPackets()V"), method = "tick()V")
	public void tickDuring(CallbackInfo info) {
		//if (storedPos!=null && storedVelocity!=null) {
			//Vec3d delta = getPos().subtract(storedPos);
			//System.out.println("Delta position: "+delta);
			
			microgravity_killTickMovement();
			
			
		//}
		//storedPos = null;
		//storedVelocity = null;
	}
	
	public void microgravity_killTickMovement() {
		if (microgravity_storedPos!=null && microgravity_storedVelocity!=null) {
			//this.setPos(microgravity_storedPos.x, microgravity_storedPos.y, microgravity_storedPos.z);
			this.updatePosition(microgravity_storedPos.x, microgravity_storedPos.y, microgravity_storedPos.z);
			
			this.prevX = microgravity_storedPos.x;
			this.prevY = microgravity_storedPos.y;
			this.prevZ = microgravity_storedPos.z;
			this.lastRenderX = microgravity_storedPos.x;
			this.lastRenderY = microgravity_storedPos.y;
			this.lastRenderZ = microgravity_storedPos.z;
			this.lastX = microgravity_storedPos.x;
			this.lastBaseY = microgravity_storedPos.y;
			this.lastZ = microgravity_storedPos.z;
			
			this.fallDistance = 0f;
			
			this.upwardSpeed = 0f;
			this.horizontalSpeed = 0f;
			
			//this.updatePosition(microgravity_storedPos.x, microgravity_storedPos.y, microgravity_storedPos.z);
			this.setVelocity(0, 0, 0);
		}
		microgravity_storedPos = null;
		microgravity_storedVelocity = null;
	}
}
