package Testes;


import dao.ClienteDAOMock;
import dao.IClienteDAO;
import dao.exceptions.TipoChaveNaoEncontradaException;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClienteDAOTest {



    private IClienteDAO clienteDao;
    private Cliente cliente;


    public ClienteDAOTest () {
        clienteDao = new ClienteDAOMock();
    }

    @Before
    public void init () throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Artur");
        cliente.setCidade("São Paulo");
        cliente.setEnd("Rua Francisco da Cunha");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11962972342L);
        clienteDao.cadastrar(cliente);
    }



    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }



    @Test
     public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Artur");

        clienteDao.alterar(cliente);

        Assert.assertEquals("Artur", cliente.getNome());

    }

}

