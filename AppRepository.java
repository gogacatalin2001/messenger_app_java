public interface AppRepository<T, ID> {
    T save(T entity) throws Exception;
    T findById(ID id);
    T delete(T entity);
}
