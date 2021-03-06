/*
 * Copyright 2009 University of Zurich, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.evolizer.changedistiller.distilling;

import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.evolizer.changedistiller.model.entities.SourceCodeChange;

/**
 * A refactoring candidate is a container class that stores a {@link SourceCodeChange} with a {@link DiffNode}.
 * 
 * <p>
 * {@link Distiller} decides according to the {@link DiffNode} whether the corresponding {@link SourceCodeChange} may be
 * refactoring candidate. That is, when the change is either a attribute/class/method insert or delete.
 * 
 * <p>
 * Concrete refactoring helper use these candidate to find related insert and delete operations of attributes, classes,
 * or methods.
 * 
 * @author fluri
 * @see Distiller
 * @see AbstractRefactoringHelper
 */
public final class RefactoringCandidate {

    private SourceCodeChange fChangeOperation;
    private DiffNode fDiffNode;
    private boolean fFound;

    /**
     * Creates a new refactoring helper.
     * 
     * @param sourceCodeChange
     *            that may be related to a refactoring
     * @param diffNode
     *            that eclipse compare detected
     */
    public RefactoringCandidate(SourceCodeChange sourceCodeChange, DiffNode diffNode) {
        setSourceCodeChange(sourceCodeChange);
        setDiffNode(diffNode);
    }

    /**
     * Set that candidate is a refactoring.
     */
    public void enableRefactoring() {
        fFound = true;
    }

    /**
     * Returns the {@link DiffNode} of this refactoring candidate.
     * 
     * @return the diff node of this refactoring candidate
     */
    public DiffNode getDiffNode() {
        return fDiffNode;
    }

    /**
     * Returns the {@link SourceCodeChange} of this refactoring candidate.
     * 
     * @return the source code change of this refactoring candidate.
     */
    public SourceCodeChange getSourceCodeChange() {
        return fChangeOperation;
    }

    /**
     * Returns whether this candidate belongs actually to a refactoring.
     * 
     * @return <code>true</code> if this refactoring candidate belongs to a refactoring, <code>false</code> otherwise
     */
    public boolean isRefactoring() {
        return fFound;
    }

    private void setDiffNode(DiffNode secondElement) {
        fDiffNode = secondElement;
    }

    private void setSourceCodeChange(SourceCodeChange firstElement) {
        fChangeOperation = firstElement;
    }
}
