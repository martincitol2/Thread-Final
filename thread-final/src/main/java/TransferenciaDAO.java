import java.util.List;

public interface TransferenciaDAO {
	
	public List<Transferencia> transferenciasPendientes();
	
	public void transferir(String cbuLlegada,String cbuSalida,Double monto);
	
	public void cambiarEstadoDeImagen(Long id);

	public List<Transferencia> transferenciaPendientesSinImagen();
	
	public void cambiarEstadoTransferencia(Long id);
}
