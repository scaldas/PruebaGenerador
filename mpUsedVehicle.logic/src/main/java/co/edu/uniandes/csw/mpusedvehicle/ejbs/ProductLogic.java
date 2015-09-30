package co.edu.uniandes.csw.mpusedvehicle.ejbs;

import co.edu.uniandes.csw.mpusedvehicle.api.IProductLogic;
import co.edu.uniandes.csw.mpusedvehicle.converters.ProductConverter;
import co.edu.uniandes.csw.mpusedvehicle.dtos.ProductDTO;
import co.edu.uniandes.csw.mpusedvehicle.entities.ProductEntity;
import co.edu.uniandes.csw.mpusedvehicle.persistence.ProductPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProductLogic implements IProductLogic {

    @Inject private ProductPersistence persistence;

    /**
     * @generated
     */
    public int countProducts() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords) {
        return ProductConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ProductDTO getProduct(Long id) {
        return ProductConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ProductDTO createProduct(ProductDTO dto) {
        ProductEntity entity = ProductConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ProductDTO updateProduct(ProductDTO dto) {
        ProductEntity entity = persistence.update(ProductConverter.fullDTO2Entity(dto));
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteProduct(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ProductDTO> findByName(String name) {
        return ProductConverter.listEntity2DTO(persistence.findByName(name));
    }
}
