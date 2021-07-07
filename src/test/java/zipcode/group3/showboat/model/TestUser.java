package zipcode.group3.showboat.model;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class TestUser {

    @Test
    public void testClassAnnotation() {
        Assert.assertTrue(User.class.isAnnotationPresent(Entity.class));
    }
}
