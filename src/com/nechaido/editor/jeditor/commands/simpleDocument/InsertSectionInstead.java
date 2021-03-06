package com.nechaido.editor.jeditor.commands.simpleDocument;

import com.nechaido.editor.jeditor.Context;
import com.nechaido.editor.jeditor.commands.simpleDocument.noSelectionManipulators.InsertSection;
import com.nechaido.editor.jeditor.document.Element;

import java.util.ArrayList;

/**
 * Created by nechaido on 5/9/16.
 */
public class InsertSectionInstead extends AbstractSimpleDocumentCommand {
    private RemoveSection removeSection;
    private InsertSection insertSection;

    public InsertSectionInstead(Context context, Element[] inserts) {
        super(context, true);
        removeSection = new RemoveSection(context);
        insertSection = new InsertSection(context, inserts);
    }

    @Override
    public void execute() {
        removeSection.execute();
        insertSection.execute();
    }

    @Override
    public void unExecute() {
        insertSection.unExecute();
        removeSection.unExecute();
    }

    @Override
    public Type type() {
        return Type.INSERT;
    }
}
