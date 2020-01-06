import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class TransferenciaDAOImpl implements TransferenciaDAO {

	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Transferencia> transferenciasMayoresADiezMil() {
		return (List<Transferencia>) entityManager.createNativeQuery("select * from Transferencia where amount >= 200", Transferencia.class);
	}

	@SuppressWarnings("unchecked")
	public List<Transferencia> transferenciasPorId(Long id) {
		return (List<Transferencia>) entityManager.createNativeQuery("select * from Transferencia where id = id",Transferencia.class);
	}

}
