/*
   Copyright 2012-2015 Michael Pozhidaev <michael.pozhidaev@gmail.com>

   This file is part of the LUWRAIN.

   LUWRAIN is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   LUWRAIN is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.
*/

package org.luwrain.app.writer;

import java.util.*;
import org.apache.poi.xwpf.usermodel.*;

import org.luwrain.core.NullCheck;

class BodyView implements View
{
    private IBody body;
    private ParaView[] paraViews;
    //    private Iterator<IBodyElement> it;

    BodyView(IBody body)
    {
	this.body = body;
	NullCheck.notNull(body, "body");
    }

    void fillParaViews()
    {
	final List<XWPFParagraph> para = body.getParagraphs();
	if (para == null)
	{
	    paraViews = new ParaView[0];
	    return;
	}
	final Iterator<XWPFParagraph> it = para.iterator();
	final LinkedList<ParaView> res = new LinkedList<ParaView>();
	while(it.hasNext())
	    res.add(new ParaView(it.next()));
	paraViews = res.toArray(new ParaView[res.size()]);
    }

    @Override public int getLineCount()
    {
	return body.getBodyElements().size() + 1;
    }

    @Override public String getLine(int index)
    {
	return "";
    }

}
