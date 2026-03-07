package derekahedron.invexpplus.item;

import derekahedron.invexpplus.util.IEPUtil;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class IEPItemTags {
    public static final TagKey<Item> BISACK_FABRIC =
            ItemTags.create(IEPUtil.location("bisack_fabric"));

    public static final TagKey<Item> DINOSACK_FABRIC =
            ItemTags.create(IEPUtil.location("dinosack_fabric"));

    public static final TagKey<Item> DINOSACK_STRING =
            ItemTags.create(IEPUtil.location("dinosack_string"));

    public static final TagKey<Item> DOUBLE_BUNDLE_FABRIC =
            ItemTags.create(IEPUtil.location("double_bundle_fabric"));

    public static final TagKey<Item> DYEABLE_DOUBLE_BUNDLES =
            ItemTags.create(IEPUtil.location("dyeable_double_bundle"));

    public static final TagKey<Item> CURSED_BUNDLE_FABRIC =
            ItemTags.create(IEPUtil.location("cursed_bundle_fabric"));

    public static final TagKey<Item> CURSED_BUNDLE_STRING =
            ItemTags.create(IEPUtil.location("cursed_bundle_string"));

    public static final TagKey<Item> PRO_QUIVER_ROPE =
            ItemTags.create(IEPUtil.location("pro_quiver_rope"));

    public static final TagKey<Item> PRO_QUIVER_BARK =
            ItemTags.create(IEPUtil.location("pro_quiver_bark"));
}
