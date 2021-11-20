package tecno.tecnoPro;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;

import dao.ProductDao;
import domin.*;

@Path("productjersey")

public class ProductJersey {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("products")
	public List<Product> getProducts() throws SQLException {

		ProductDao proDao = new ProductDao();
		List<Product> allProducts = proDao.viewAllProduct();
		return allProducts;

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("products/{productid}")
	public Product getProSpe(@PathParam(value = "productid") int proid) throws SQLException {

		ProductDao proDao = new ProductDao();
		Product ProductSpe = proDao.viewProSpe(proid);
		return ProductSpe;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addpro")
	public Product addPro(@RequestBody Product pro) throws ClassNotFoundException, SQLException {

		ProductDao proDao = new ProductDao();
		proDao.addProduct(pro);

		return pro;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updpro")
	public Product updPro( @RequestBody Product pro) throws ClassNotFoundException, SQLException {

		ProductDao proDao = new ProductDao();
		proDao.updProduct(pro);

		return pro;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delpro/{productid}")
	public int delProduct(@PathParam(value = "productid") int proid) throws SQLException, ClassNotFoundException {

		ProductDao proDao = new ProductDao();
		proDao.deleteProduct(proid);
		return 101;

	}

}
