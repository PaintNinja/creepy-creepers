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
package dev.tophatcat.creepycreepers.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.tophatcat.creepycreepers.entities.GhostlyCreeperEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.Nonnull;

public class GhostlyCreeperModel extends EntityModel<GhostlyCreeperEntity> {

    private final ModelRenderer body;
    private final ModelRenderer head;

    public GhostlyCreeperModel() {
        texWidth = 64;
        texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 6.0F, 0.0F);
        body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F,
            8.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(head);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F,
            8.0F, 8.0F, 8.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(@Nonnull GhostlyCreeperEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
