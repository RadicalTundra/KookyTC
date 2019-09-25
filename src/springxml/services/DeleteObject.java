package springxml.services;

public class DeleteObject implements ModifyObjectService{
    @Override
    public String modifyObject(String objectType) {
        return "An Object of type " + objectType + " has been deleted.";
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
