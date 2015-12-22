
package org.luwrain.app.writer;

import org.apache.poi.xwpf.usermodel.*;
import org.luwrain.core.NullCheck;

class ParaView
{
    XWPFParagraph para;

    ParaView(XWPFParagraph para)
    {
	this.para = para;NullCheck.notNull(para, "para");
    }
}
