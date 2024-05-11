package org.jfm.infra.repository.mapper;

import org.jfm.bootloader.QuarkusMappingConfig;
import org.jfm.domain.valueObjects.ItemPedido;
import org.jfm.infra.repository.entities.ItemPedidoEntity;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface ItemPedidoMapper {
    ItemPedido toDomain(ItemPedidoEntity itemPedido);

    ItemPedidoEntity toEntity(ItemPedido itemPedido);
}
