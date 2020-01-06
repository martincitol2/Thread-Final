import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TransferenciaRepository extends CrudRepository<Transferencia,Long>{
	
	Optional<Transferencia> findById(Long id);
}
