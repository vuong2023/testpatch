package app.revanced.patches.youtube.player.seekmessage.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import app.revanced.patches.youtube.utils.resourceid.patch.SharedResourceIdPatch.Companion.SeekUndoEduContainer
import app.revanced.util.bytecode.isWideLiteralExists

object SeekUndoEduContainer : MethodFingerprint(
    returnType = "V",
    customFingerprint = { methodDef, _ -> methodDef.isWideLiteralExists(SeekUndoEduContainer) }
)