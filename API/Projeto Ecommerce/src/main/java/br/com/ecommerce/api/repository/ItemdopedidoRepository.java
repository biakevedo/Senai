package br.com.ecommerce.api.repository;

import br.com.ecommerce.api.model.Itemdopedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemdopedidoRepository extends JpaRepository<Itemdopedido, Integer > {

}
