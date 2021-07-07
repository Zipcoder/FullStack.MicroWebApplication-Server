package zipcode.group3.showboat.model;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class TestVideo {

    @Test
    public void testClassAnnotation() {
        Assert.assertTrue(Video.class.isAnnotationPresent(Entity.class));
    }
}
