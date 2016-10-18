package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputPeerNotifySettings extends TLInputPeerNotifySettings {

    public static final int ID = 0x38935eb2;

    public int flags;
    public int mute_until;
    public String sound;

    public InputPeerNotifySettings() {
    }

    public InputPeerNotifySettings(int flags, int mute_until, String sound) {
        this.flags = flags;
        this.mute_until = mute_until;
        this.sound = sound;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        mute_until = buffer.readInt();
        sound = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeInt(mute_until);
        buff.writeString(sound);
    }

    public boolean is_show_previews() {
        return (flags & (1 << 0)) != 0;
    }

    public void set_show_previews(boolean v) {
        if (v) {
            flags |= (1 << 0);
        } else {
            flags &= ~(1 << 0);
        }
    }

    public boolean is_silent() {
        return (flags & (1 << 1)) != 0;
    }

    public void set_silent(boolean v) {
        if (v) {
            flags |= (1 << 1);
        } else {
            flags &= ~(1 << 1);
        }
    }

    public int getConstructor() {
        return ID;
    }
}