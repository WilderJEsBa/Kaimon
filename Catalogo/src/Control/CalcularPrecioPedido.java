/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.PedidoDAO;
import DAO.ProductoDAO;
import Entidad.Pedido;
import Entidad.PedidoItem;
import java.util.List;

/**
 *
 * @author wilde
 */
public class CalcularPrecioPedido {
    
    public PedidoDAO dao = new PedidoDAO();

    public String verificarExistencias(Pedido pedido){ 
        for(PedidoItem p : pedido.getItems()){
            if(p.getCantidadItem() >=  p.getProducto().getCantidad())
            return ("Produtos insuficientes, por favor verifique");
        }
        dao.crear(pedido);
        pedido.setPrecioTotal(calcularPrecioPedido(pedido.getItems()));
        return ("Operacion exitosa");
    }
    
    public String aprobarPedido(Pedido pedido){
        dao.actualizar(pedido, pedido);
        restarExistencias(pedido.getItems());
        return ("Pedido aprobado con exito");
    }
    
    private int calcularPrecioPedido(List<PedidoItem> items){
        int precioPedido = 0;
        for(PedidoItem pi: items){
            precioPedido += pi.getPrecioActualItem()*pi.getCantidadItem();
        }
        return precioPedido;
    }
    
    private void restarExistencias(List<PedidoItem> items){
        ProductoDAO pdao = new ProductoDAO();
        for(PedidoItem pi: items){
            pdao.actualizarExistencia(pi.getProducto(), pi.getProducto().getCantidad() - pi.getCantidadItem());
        }
    }
    
    
}
