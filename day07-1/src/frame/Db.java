package frame;

import java.util.List;

// 제네릭
// 인터페이스에 어떤 타입이 들어올지 모른다. 키값 벨류값처럼 의미를 정해준다
// 뭘 해도 상관없다.
public interface Db<K, V> {
    void insert(V v) throws Exception;
    void update(V v) throws Exception;
    void delete(K k) throws Exception;
    V select(K k) throws Exception;
    List<V> select() throws Exception;
    default List<V> searchByName(String name) throws Exception {
        return null; // 인터페이스이기 때문에 여기서 리턴할게 없으니 null
    }
}
