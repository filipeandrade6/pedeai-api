package org.jfm.infra.payment.adaptermock;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jfm.domain.entities.Cliente;
import org.jfm.domain.entities.Pedido;
import org.jfm.domain.exceptions.ErrosSistemaEnum;
import org.jfm.domain.exceptions.Exceptions.PagamentoException;
import org.jfm.domain.ports.PagamentoGateway;
import org.jfm.domain.valueobjects.Pagamento;
import org.jfm.infra.payment.adaptermock.restclient.PaymentAdapterMock;
import org.jfm.infra.payment.adaptermock.restclient.dto.RequestDto;
import org.jfm.infra.payment.adaptermock.restclient.dto.ResponseDto;

@ApplicationScoped
public class PagamentoGatewayImpl implements PagamentoGateway {

    @RestClient 
    PaymentAdapterMock restClient;

    @Override
    public Pagamento criarPagamento(Cliente cliente, Pedido pedido, int valor) {
        try {
            UUID uuid = UUID.randomUUID();
    
            RequestDto request = new RequestDto(uuid, valor, pedido.toString(), cliente.getCpf());
            ResponseDto response = restClient.criarPagamento(request);
    
            return new Pagamento(uuid, response.id(), response.qrCodeBase64());

        } catch (Exception e) {
           throw new PagamentoException(ErrosSistemaEnum.PAYMENT_ERROR.getMessage());
        }
    }

}
