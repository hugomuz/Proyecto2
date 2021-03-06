package otros;

import java.util.Date;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Individual;
import modelo.ItemOrden;
import modelo.Orden;
import modelo.Producto;
import modelo.Usuario;

public class DataSistema {

    public static Cliente[] clientesA = new Cliente[8];
    public static Producto[] productosA = new Producto[8];
    public static Usuario[] usuarios = new Usuario[2];
    public static Orden[] ordenesA = new Orden[8];

    public static void cargarDatosClientes() {

        Individual in1 = new Individual("2080 32852 0102", "Sharon Rodriguez", "6ta calle 12-5 Zona 1 Ciudad de Guatemala", "7845-1236", "individual");
        Individual in2 = new Individual("2041 21384 0101", "Jose Melgar", "12 Caalle A zona 12", "7845-9621", "individual");
        Individual in3 = new Individual("7845 25478 0120", "Yesesica Polanco", "5ta Calle Zona 1 Mixco", "4471-3737", "individual");
        Individual in4 = new Individual("7863 01478 0101", "Hugo Muz", "6ta Calle A Zona 2 ", "4710-7845", "individual");


        Empresa em1 = new Empresa("CMUZ", 20, "EMPRESA Eduardo Muz", "6ta Calle C Zona 21", "1245-1234", "empresa");
        Empresa em2 = new Empresa("CMUZ", 30, "EMPRESA Daniel Melgar", "12 calle 12 Avenida Zona 1", "7852-0147", "empresa");
        Empresa em3 = new Empresa("CQUIÑONEZ", 25, "EMPRESA Estuado Quiñonez", "13 Calle Colonia Santa Fe", "9630-0128", "empresa");
        Empresa em4 = new Empresa("CCASTRO", 45, "EMPRESA Cindy Castro", "5ta Avenida Boca del Monte", "7474-3737", "empresa");


        clientesA[0] = in1;
        clientesA[1] = in2;
        clientesA[2] = in3;
        clientesA[3] = in4;
        clientesA[4] = em1;
        clientesA[5] = em2;
        clientesA[6] = em3;
        clientesA[7] = em4;

    }

    public static void cargarDatosProductos() {
        Producto p1 = new Producto("Bujia", "Bujias de iridium", 80, 100);
        Producto p2 = new Producto("Empaques de Culata", "Empaques de carro tipo,  mazda, toyota, nissan", 2000, 20);
        Producto p3 = new Producto("Hojas de resorte", "Para micro bus GMC", 800, 15);
        Producto p4 = new Producto("Filtro de aire", "Para carros de 2009 en adelante", 50, 500);
        Producto p5 = new Producto("Pastillas", "Para automoviles tipo Sedan", 70, 200);
        Producto p6 = new Producto("Cojinetes", "Para carro pequeño", 20, 600);
        Producto p7 = new Producto("Amortiguadores", "Para camiones pequeños", 800, 70);
        Producto p8 = new Producto("Bobina", "Bobina de Kia Rio", 150, 250);

        productosA[0] = p1;
        productosA[1] = p2;
        productosA[2] = p3;
        productosA[3] = p4;
        productosA[4] = p5;
        productosA[5] = p6;
        productosA[6] = p7;
        productosA[7] = p8;
    }

    public static void cargarDatosUsuarios() {

        Usuario user1 = new Usuario("hmuz", "hmuzprogra2");
        Usuario user2 = new Usuario("dmelgar", "dmelgarprogra2");

        usuarios[0] = user1;
        usuarios[1] = user2;
    }

    public static void cargarDatosOrdenes() {

        Orden orden1 = new Orden(new Date());
        orden1.setCliente(clientesA[0]);
        ItemOrden item1 = new ItemOrden(100 + orden1.getId(), 3, productosA[0]);
        ItemOrden item2 = new ItemOrden(200 + orden1.getId(), 4, productosA[1]);
        orden1.setItem1(item1);
        orden1.setItem2(item2);
        orden1.setPrecioEnvio(10000);
        orden1.setTipoEnvio("Urgente");
        orden1.setEstado("Pendiente");
        orden1.setDiasEnvio(5);
        orden1.getTotalOrden();

        Orden orden2 = new Orden(new Date());
        orden2.setCliente(clientesA[1]);
        ItemOrden item3 = new ItemOrden(100 + orden2.getId(), 3, productosA[0]);
        ItemOrden item4 = new ItemOrden(200 + orden2.getId(), 4, productosA[1]);
        orden2.setItem1(item3);
        orden2.setItem2(item4);
        orden2.setPrecioEnvio(10000);
        orden2.setTipoEnvio("Urgente");
        orden2.setEstado("Pendiente");
        orden2.setDiasEnvio(5);
        orden2.getTotalOrden();

       
        Orden orden3 = new Orden(new Date());
        orden3.setCliente(clientesA[2]);
        ItemOrden item5 = new ItemOrden(100 + orden3.getId(), 3, productosA[4]);
        ItemOrden item6 = new ItemOrden(200 + orden3.getId(), 4, productosA[5]);
        orden3.setItem1(item3);
        orden3.setItem2(item4);
        orden3.setPrecioEnvio(10000);
        orden3.setTipoEnvio("Urgente");
        orden3.setEstado("Pendiente");
        orden3.setDiasEnvio(5);
        orden3.getTotalOrden();

         
        Orden orden4 = new Orden(new Date());
        orden4.setCliente(clientesA[3]);
        ItemOrden item7 = new ItemOrden(100 + orden4.getId(), 3, productosA[6]);
        ItemOrden item8 = new ItemOrden(200 + orden4.getId(), 4, productosA[7]);
        orden4.setItem1(item7);
        orden4.setItem2(item8);
        orden4.setPrecioEnvio(10000);
        orden4.setTipoEnvio("Urgente");
        orden4.setEstado("Pendiente");
        orden4.setDiasEnvio(5);
        orden4.getTotalOrden();

     
        Orden orden5 = new Orden(new Date());
        orden5.setCliente(clientesA[4]);
        ItemOrden item9 = new ItemOrden(100 + orden5.getId(), 3, productosA[1]);
        ItemOrden item10 = new ItemOrden(200 + orden5.getId(), 4, productosA[2]);
        orden5.setItem1(item9);
        orden5.setItem2(item10);
        orden5.setPrecioEnvio(10000);
        orden5.setTipoEnvio("Urgente");
        orden5.setEstado("Pendiente");
        orden5.setDiasEnvio(5);
        orden5.getTotalOrden();

        
        Orden orden6 = new Orden(new Date());
        orden6.setCliente(clientesA[5]);
        ItemOrden item11 = new ItemOrden(100 + orden6.getId(), 3, productosA[3]);
        ItemOrden item12 = new ItemOrden(200 + orden6.getId(), 4, productosA[4]);
        orden6.setItem1(item11);
        orden6.setItem2(item12);
        orden6.setPrecioEnvio(10000);
        orden6.setTipoEnvio("Urgente");
        orden6.setEstado("Pendiente");
        orden6.setDiasEnvio(5);
        orden6.getTotalOrden();

       
        Orden orden7 = new Orden(new Date());
        orden7.setCliente(clientesA[6]);
        ItemOrden item13 = new ItemOrden(100 + orden3.getId(), 3, productosA[5]);
        ItemOrden item14 = new ItemOrden(200 + orden3.getId(), 4, productosA[6]);
        orden7.setItem1(item13);
        orden7.setItem2(item14);
        orden7.setPrecioEnvio(10000);
        orden7.setTipoEnvio("Urgente");
        orden7.setEstado("Pendiente");
        orden7.setDiasEnvio(5);
        orden7.getTotalOrden();

        Orden orden8 = new Orden(new Date());
        orden8.setCliente(clientesA[7]);
        ItemOrden item15 = new ItemOrden(100 + orden3.getId(), 3, productosA[7]);
        ItemOrden item16 = new ItemOrden(200 + orden3.getId(), 4, productosA[0]);
        orden8.setItem1(item15);
        orden8.setItem2(item16);
        orden8.setPrecioEnvio(10000);
        orden8.setTipoEnvio("Urgente");
        orden8.setEstado("Pendiente");
        orden8.setDiasEnvio(5);
        orden8.getTotalOrden();

        ordenesA[0] = orden1;
        ordenesA[1] = orden2;
        ordenesA[2] = orden3;
        ordenesA[3] = orden4;
        ordenesA[4] = orden5;
        ordenesA[5] = orden6;
        ordenesA[6] = orden7;
        ordenesA[7] = orden8;
        
   

    }

}
