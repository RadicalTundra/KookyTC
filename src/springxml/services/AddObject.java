package springxml.services;

public class AddObject implements ModifyObjectService {
    @Override
    public String modifyObject(String objectType) {
        return "An Object of type " + objectType + " has been created.";
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
