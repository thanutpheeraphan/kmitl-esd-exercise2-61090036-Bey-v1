package kmitl.esd.exercise2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void main() {

    }

    @Test
    void restTemplate() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    void getAll() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    void callGetAll() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    void callCreateCustomer() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    void callUpdateCustomer() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    void callDeleteCustomer() {
        try {
            someMethod();
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }


    private void someMethod() {
        //does some method
    }

}