package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tinhTongmangTest {

    public tinhTongmang TinhTongmang;

    @BeforeEach
    void setup(){
        TinhTongmang = new tinhTongmang();
    }

    @Test
    void test1(){
        int a[] = {-2 , -4 , -9 , -10 , -22};
        int kqthucte = TinhTongmang.tinhTong(a);
        int kqkyvong = -47;
        assertEquals(kqkyvong,kqthucte);
    }

    @Test
    void test2(){
        int a[] = {5,10,15,30};
        int kqthucte = TinhTongmang.tinhTong(a);
        int kqkyvong = 60;
        assertEquals(kqkyvong,kqthucte);

    }

    @Test
    void test3(){
        int a[]= {};
        int kqthucte = TinhTongmang.tinhTong(a);
        int kqkyvong = 0;
        assertEquals(kqkyvong,kqthucte);
    }


}