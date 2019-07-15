package nestedclass;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author 文通
 * @since 2019/7/11
 */
public class StaticNestedClassExample implements Serializable {

    private String name;

    private Person person;

    private List<Person> friends;

    public static class Person implements Serializable {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("age=" + age)
                    .toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StaticNestedClassExample.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("person=" + person)
                .add("friends=" + friends)
                .toString();
    }
}
