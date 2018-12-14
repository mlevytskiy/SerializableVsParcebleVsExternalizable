package serializable.petproject.serializablevsparceblevsexternalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by max on 12/12/18.
 */

public class MyExternalizbleClass implements Externalizable {

    public static final long serialVersionUID = 1865151003590118998L;
    public String mStringData = "";
    public int mIdenty = 0;
    public boolean mIsActive = false;
    public float mDest = 0.0f;
    public ArrayList<String> mStringList;

    public MyExternalizbleClass() {
        mStringData = UUID.randomUUID().toString();

        mStringList = new ArrayList<String>();
        Random rand = new Random();
        int maxI = rand.nextInt();

        for (int i = 0; i < maxI % 15; i++)
        {
            mStringList.add(UUID.randomUUID().toString());
        }

        mIdenty = rand.nextInt();
        mIsActive = rand.nextBoolean();
        mDest = rand.nextFloat();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(mStringData);
        out.writeInt(mIdenty);
        out.writeBoolean(mIsActive);
        out.writeFloat(mDest);
        out.writeObject(mStringList);

    }

    @Override
    public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
        mStringData = input.readUTF();
        mIdenty = input.readInt();
        mIsActive = input.readBoolean();
        mDest = input.readFloat();
        mStringList = (ArrayList<String>) input.readObject();
    }

}
