/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.L57.contacts;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class TopPeers extends org.telegram.tl.contacts.TLTopPeers {

    public static final int ID = 0x70b772a8;

    public TLVector<org.telegram.tl.TLTopPeerCategoryPeers> categories;
    public TLVector<org.telegram.tl.TLChat> chats;
    public TLVector<org.telegram.tl.TLUser> users;

    public TopPeers() {
        this.categories = new TLVector<>();
        this.chats = new TLVector<>();
        this.users = new TLVector<>();
    }

    public TopPeers(TLVector<org.telegram.tl.TLTopPeerCategoryPeers> categories, TLVector<org.telegram.tl.TLChat> chats, TLVector<org.telegram.tl.TLUser> users) {
        this.categories = categories;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        categories = (TLVector<org.telegram.tl.TLTopPeerCategoryPeers>) buffer.readTLObject(APIContext.getInstance());
        chats = (TLVector<org.telegram.tl.TLChat>) buffer.readTLObject(APIContext.getInstance());
        users = (TLVector<org.telegram.tl.TLUser>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(28);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(categories);
        buff.writeTLObject(chats);
        buff.writeTLObject(users);
    }


    public int getConstructor() {
        return ID;
    }
}