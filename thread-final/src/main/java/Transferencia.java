import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.GenericGenerator;

@NamedNativeQueries({ 
	  @NamedNativeQuery(
	    name = "callgetTransfers", 
	    query = "CALL getTransfers(:cbu_entrada,:cbu_salida,:monto)", 
	    resultClass = Transferencia.class) 
	})
@Entity
public class Transferencia {

    @Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", cbuSalida=" + cbuSalida
				+ ", cbuEntrada=" + cbuEntrada + ", estado=" + estado + ", imagen=" + imagen + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date fecha;

    private Double monto;
    
    @Column(name="cbu_salida")
    private String cbuSalida;

    @Column(name="cbu_entrada")
    private String cbuEntrada;

    private String estado;

    private Boolean imagen;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getCbuSalida() {
        return cbuSalida;
    }

    public void setCbuSalida(String cbuSalida) {
        this.cbuSalida = cbuSalida;
    }

    public String getCbuEntrada() {
        return cbuEntrada;
    }

    public void setCbuEntrada(String cbuEntrada) {
        this.cbuEntrada = cbuEntrada;
    }

    public Transferencia() {

    }

    public long getId() {
        return id;
    }

	public Boolean getImagen() {
		return imagen;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImagen(Boolean imagen) {
		this.imagen = imagen;
	}
	
	
	
	

 
    
}