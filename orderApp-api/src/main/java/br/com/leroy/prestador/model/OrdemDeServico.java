package br.com.leroy.prestador.model;
import javax.persistence.*;
import java.util.UUID;

@Entity
public class OrdemDeServico {

	public OrdemDeServico() {
		this.status = ServicoStatus.RECEBIDO;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;

	@Enumerated(EnumType.STRING)
	private ServicoStatus status;

	private String nomeCliente;

	private String nomePrestador;
	private String endereco;

	private String nomeEmpresa;

	private String produto;


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ServicoStatus getStatus() {
		return status;
	}

	public void setStatus(ServicoStatus status) {
		this.status = status;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomePrestador() {
		return nomePrestador;
	}

	public void setNomePrestador(String nomePrestador) {
		this.nomePrestador = nomePrestador;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
}


