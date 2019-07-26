/**  
* @Title: BaseMapper.java
* @Description:  
* @author roger  
* @date 2019年7月23日  
* @version 1.0  
*/ 
package com.roger.ims.dao;

import java.util.List;

/**  
* @Title: BaseMapper  
* @Description: 增删改查
* @author roger  
* @date 2019年7月23日  
*/
public interface BaseDao<T> {
	
	/**  
	 * @Title: add
	 * @Description: 
	 * @param t
	 * @return  
	 */  
	public int add(T t);
	/**  
	 * @Title: update
	 * @Description: 
	 * @param t
	 * @return  
	 */  
	public int update(T t);
	/**  
	 * @Title: delete
	 * @Description: 
	 * @param t
	 * @return  
	 */  
	public int delete(T t);
	/**  
	 * @Title: findOne
	 * @Description: 
	 * @param t
	 * @return  
	 */  
	public T findOne(T t);
	/**  
	 * @Title: findAll
	 * @Description: 
	 * @return  
	 */  
	public List<T> findAll(T t);	
}
