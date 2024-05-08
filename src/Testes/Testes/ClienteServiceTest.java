package Testes;


import dao.ClienteDAO;
import dao.ClienteDAOMock;
import dao.IClienteDAO;
import dao.exceptions.TipoChaveNaoEncontradaException;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Test;
import service.ClienteService;
import service.IClienteService;

public class ClienteServiceTest {


    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest () {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init (){
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Artur");
        cliente.setCidade("São Paulo");
        cliente.setEnd("Rua Francisco da Cunha");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11962972342L);

    }

   @Test
    public void pesquisarCliente(){

       Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
       Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Artur");
        clienteService.alterar(cliente);

        Assert.assertEquals("Artur", cliente.getNome());
    }
}
