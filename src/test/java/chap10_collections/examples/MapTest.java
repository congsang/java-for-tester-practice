package chap10_collections.examples;

import javafortesters.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class MapTest {

    @Test
    public void mapExplored(){
        Map<String,User> mapa = new HashMap<>();
        Map<String,User> mapb = new HashMap<String,User>();
        Map<String,User> mapc = new <String,User>HashMap();
    }

    @Test
    public void canAddKeyValuePairToAMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Assert.assertEquals(3, map.size());

        map.put("key1", "newvalue1");
        Assert.assertEquals("newvalue1", map.get("key1"));
    }

    @Test
    public void canRemoveKeyValuePairUsingKeyFromMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key1");

        Assert.assertEquals(2, map.size());
    }

    @Test
    public void cannotRemoveKeyValuePairwhenKeyIsWrongFromMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key15");

        Assert.assertEquals(3, map.size());
    }

    @Test
    public void canRetrieveAValueFromMapWithKey(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Assert.assertEquals("value1", map.get("key1"));
        Assert.assertEquals("value2", map.get("key2"));
        Assert.assertEquals("value3", map.get("key3"));

        Assert.assertEquals(null, map.get("key4"));
    }

    @Test
    public void canEmptyAMapWithClear(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Assert.assertEquals(3, map.size());

        map.clear();
        Assert.assertEquals(0, map.size());
        Assert.assertTrue(map.isEmpty());
    }


    @Test
    public void canCheckContentsOfMap(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Assert.assertTrue(map.containsKey("key1"));
        Assert.assertFalse(map.containsKey("key23"));

        Assert.assertTrue(map.containsValue("value2"));
        Assert.assertFalse(map.containsValue("value23"));
    }

    @Test
    public void canPutOneMapInAnotherMap(){
        Map<String,String> map = new HashMap<>();
        Map<String,String> mapToAdd = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        mapToAdd.put("key1", "keyvalue1");
        mapToAdd.put("key4", "value4");

        map.putAll(mapToAdd);

        Assert.assertEquals(4, map.size());
        Assert.assertEquals("keyvalue1", map.get("key1"));
    }

    @Test
    public void canUseEntrySet(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for( Map.Entry<String,String> entry : entries){
            entry.setValue("bob");
        }

        Assert.assertEquals("bob", map.get("key1"));
        Assert.assertEquals("bob", map.get("key2"));
        Assert.assertEquals("bob", map.get("key3"));
    }


    @Test
    public void canGetAllValues(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Collection<String> values = map.values();

        Assert.assertEquals(map.size(), values.size());
    }

    @Test
    public void canGetAllKeys(){
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<String> keys = map.keySet();

        Assert.assertEquals(map.size(), keys.size());
    }

    @Test
    public void canGetAllKeysAsSortedSet(){
        Map<String,String> map = new HashMap<>();

        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");

        SortedSet<String> keys = new TreeSet<>(map.keySet());

        String[] keysa = new String[keys.size()];
        keys.toArray(keysa);

        Assert.assertEquals("key1", keysa[0]);
        Assert.assertEquals("key2", keysa[1]);
        Assert.assertEquals("key3", keysa[2]);
    }
}
