package zipcode.group3.showboat.model;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class TestComment {

    @Test
    public void testClassAnnotation() {
        Assert.assertTrue(Comment.class.isAnnotationPresent(Entity.class));
    }
}
