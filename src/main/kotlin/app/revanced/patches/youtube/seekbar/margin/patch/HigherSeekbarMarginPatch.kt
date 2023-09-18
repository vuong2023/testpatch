package app.revanced.patches.youtube.seekbar.margin.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name

import app.revanced.patcher.data.ResourceContext

import app.revanced.extensions.doRecursively

import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.youtube.utils.annotations.YouTubeCompatibility
import app.revanced.patches.youtube.utils.settings.resource.patch.SettingsPatch
import org.w3c.dom.Element

@Patch
@Name("Higher fullscreen seekbar height")
@Description("When turned on Hide Fullscreen Bottom Container, the seekbar become unclickable for some users. This patch will solve it.")
@DependsOn([SettingsPatch::class])
@YouTubeCompatibility

class HigherSeekbarMarginPatch : ResourcePatch {
    override fun execute(context: ResourceContext) {
        context.xmlEditor["res/layout/youtube_controls_bottom_ui_container.xml"].use { editor ->
            editor.file.doRecursively loop@{
                if (it !is Element) return@loop

                it.getAttributeNode("android:id")?.let { attribute ->
                    if (attribute.textContent == "@id/quick_actions_container") {
                        it.getAttributeNode("android:paddingTop").textContent = "20.0dip"
                    }
                }
            }
        }

        SettingsPatch.updatePatchStatus("higher-seekbar-height")
    }
}