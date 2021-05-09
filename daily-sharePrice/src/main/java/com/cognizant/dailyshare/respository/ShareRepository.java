package com.cognizant.dailyshare.respository;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * This is a repository for sharedetails class
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.dailyshare.model.ShareDetails;
@Repository
public interface ShareRepository extends JpaRepository<ShareDetails,String>{
	
	public List<ShareDetails> findAll();
	
	public ShareDetails findByShareName(String shareName);

	public ShareDetails findByShareId(String shareId);
	
	@Query("SELECT s FROM ShareDetails s WHERE s.shareId IN (:shareID) order by s.shareId")
	public List<ShareDetails> findShareValuesListByShareId(@Param("shareID") List<String> shareId);
 
}
