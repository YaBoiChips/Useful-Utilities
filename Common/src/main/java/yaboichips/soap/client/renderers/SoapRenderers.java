package yaboichips.soap.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import yaboichips.soap.core.SoapEntities;
import yaboichips.soap.core.SoapTileEntities;

public class SoapRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(SoapEntities.GREMLIN, GremlinRenderer::new);
        registerStrategy.register(SoapEntities.PIE, ThrownItemRenderer::new);
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
