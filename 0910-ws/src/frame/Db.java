package frame;

import java.util.List;

public interface Db <K, V> {
    void insert(V v) throws Exception;
    void update(V v) throws Exception;
    void delete(K k) throws Exception;
    V select(K k) throws Exception; // id로 유저 검색
    List<V> select() throws Exception; // 전체 유저 정보 반환
    default List<V> searchByName(String name) throws Exception{ // 이름으로 유저 검색
        return null;
    }
}

