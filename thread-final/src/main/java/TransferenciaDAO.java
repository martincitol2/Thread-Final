import java.util.List;

public interface TransferenciaDAO {
	
	public List<Transferencia> transferenciasMayoresADiezMil();
	
	public List<Transferencia> transferenciasPorId(Long id);
}
