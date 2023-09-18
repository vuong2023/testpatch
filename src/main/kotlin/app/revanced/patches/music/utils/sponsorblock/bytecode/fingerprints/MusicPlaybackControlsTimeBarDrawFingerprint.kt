package app.revanced.patches.music.utils.sponsorblock.bytecode.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object MusicPlaybackControlsTimeBarDrawFingerprint : MethodFingerprint(
    returnType = "V",
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("/MusicPlaybackControlsTimeBar;")
                && methodDef.name == "draw"
    }
)