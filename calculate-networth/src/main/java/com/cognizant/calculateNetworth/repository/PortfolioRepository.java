package com.cognizant.calculateNetworth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.calculateNetworth.model.Portfolio;

/**
 * This is the repository layer for Portfolio class
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

}
