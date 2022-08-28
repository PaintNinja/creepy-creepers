/*
 * Creepy Creepers - https://github.com/tophatcats-mods/creepy-creepers
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.creepycreepers.client.rendering;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.tophatcat.creepycreepers.CreepyCreepers;
import dev.tophatcat.creepycreepers.client.models.GhostlyCreeperModel;
import dev.tophatcat.creepycreepers.entities.GhostlyCreeperEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class GhostlyCreeperRenderer extends MobRenderer<GhostlyCreeperEntity, GhostlyCreeperModel> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(CreepyCreepers.MOD_ID,
        "textures/entity/ghostly_creeper.png");

    public GhostlyCreeperRenderer(final EntityRendererManager context) {
        super(context, new GhostlyCreeperModel(), 0.0F);
    }

    @Override
    protected void scale(@Nonnull GhostlyCreeperEntity entity, @Nonnull MatrixStack poseStack, float partialTickTime) {
        //TODO Fix Ghostly Creeper transparency!
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        float f = entity.getSwelling(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        poseStack.scale(f2, f3, f2);
    }

    @Override
    public void render(@Nonnull GhostlyCreeperEntity entity, float entityYaw, float partialTicks,
                       @Nonnull MatrixStack matrixStack, @Nonnull IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entity, entityYaw, partialTicks, matrixStack, bufferIn, packedLightIn);
    }

    @Override
    protected float getWhiteOverlayProgress(GhostlyCreeperEntity livingEntity, float partialTicks) {
        float f = livingEntity.getSwelling(partialTicks);
        return f * 10.0F % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull GhostlyCreeperEntity entity) {
        return RESOURCE_LOCATION;
    }
}
