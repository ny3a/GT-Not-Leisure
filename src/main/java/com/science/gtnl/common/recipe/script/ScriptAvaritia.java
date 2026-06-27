package com.science.gtnl.common.recipe.script;

import static kubatech.api.enums.ItemList.HighTemperatureGasCooledReactor;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.scripts.IScriptLoader;
import com.glodblock.github.common.item.ItemFluidPacket;
import com.reavaritia.utils.enums.ReAvaItemList;
import com.science.gtnl.utils.enums.GTNLItemList;
import com.science.gtnl.utils.enums.ModList;
import com.science.gtnl.utils.item.ItemUtils;

import appeng.api.AEApi;
import bartworks.common.loaders.ItemRegistry;
import cpw.mods.fml.common.Optional;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import ganymedes01.etfuturum.configuration.configs.ConfigMixins;
import ggfab.GGItemList;
import goodgenerator.loader.Loaders;
import goodgenerator.util.ItemRefer;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MetaTileEntityIDs;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.material.Particle;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtnhlanth.common.item.MaskList;
import gtnhlanth.common.register.LanthItemList;
import kekztech.common.TileEntities;
import tectech.thing.CustomItemList;

public class ScriptAvaritia implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
            Mods.AppliedEnergistics2.ID,
            Mods.EnderIO.ID,
            Mods.SGCraft.ID,
            Mods.TecTech.ID,
            Mods.AE2FluidCraft.ID,
            Mods.GregTech.ID,
            Mods.NewHorizonsCoreMod.ID,
            ModList.ScienceNotLeisure.ID);
    }

    @Override
    public void loadRecipes() {
        var aeItems = AEApi.instance()
            .definitions()
            .items();
        var aeMaterials = AEApi.instance()
            .definitions()
            .materials();
        var aeBlocks = AEApi.instance()
            .definitions()
            .blocks();

        ItemStack eternityFluidPacket = ItemFluidPacket.newStack(Materials.Eternity.getMolten(114514));
        ItemStack magMatterFluidPacket = ItemFluidPacket.newStack(Materials.MagMatter.getMolten(114514));
        ItemStack universiumFluidPacket = ItemFluidPacket.newStack(Materials.Universium.getMolten(114514));
        ItemStack quarkGluonPlasmaFluidPacket = ItemFluidPacket.newStack(Materials.QuarkGluonPlasma.getFluid(114514));
        ItemStack sgCrystalSlurryFluidPacket = ItemFluidPacket
            .newStack(Materials.StargateCrystalSlurry.getFluid(114514));
        ItemStack mcsmFluidPacket = ItemFluidPacket.newStack(Materials.MHDCSM.getMolten(114514));
        ItemStack dimensionallyShiftedSuperFluidPacket = ItemFluidPacket
            .newStack(Materials.DimensionallyShiftedSuperfluid.getFluid(114514));
        ItemStack sixPhasedCopperFluidPacket = ItemFluidPacket.newStack(Materials.SixPhasedCopper.getMolten(114514));
        ItemStack phononMediumFluidPacket = ItemFluidPacket.newStack(Materials.PhononMedium.getFluid(114514));
        ItemStack antimatterFluidPacket = ItemFluidPacket.newStack(Materials.Antimatter.getFluid(114514));
        ItemStack plasmaLeadFluidPacket = ItemFluidPacket.newStack(Materials.Lead.getPlasma(114514));
        ItemStack dtrFluidPacket = ItemFluidPacket.newStack(Materials.DTR.getFluid(114514));
        ItemStack plasmaPlutonium241FluidPacket = ItemFluidPacket.newStack(Materials.Plutonium241.getPlasma(114514));
        ItemStack plasmaAmericiumPacket = ItemFluidPacket.newStack(Materials.Americium.getPlasma(114514));
        ItemStack plasmaNeonPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().NEON.getPlasma(), 114514));
        ItemStack plasmaGermaniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().GERMANIUM.getPlasma(), 114514));
        ItemStack plasmaKryptonPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().KRYPTON.getPlasma(), 114514));
        ItemStack plasmaSeleniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().SELENIUM.getPlasma(), 114514));
        ItemStack plasmaRadonPacket = ItemFluidPacket.newStack(Materials.Radon.getPlasma(114514));
        ItemStack plasmaHafniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().HAFNIUM.getPlasma(), 114514));
        ItemStack plasmaSulfurPacket = ItemFluidPacket.newStack(Materials.Sulfur.getPlasma(114514));
        ItemStack plasmaOxygenPacket = ItemFluidPacket.newStack(Materials.Oxygen.getPlasma(114514));
        ItemStack plasmaNitrogenPacket = ItemFluidPacket.newStack(Materials.Nitrogen.getPlasma(114514));
        ItemStack plasmaHeliumPacket = ItemFluidPacket.newStack(Materials.Helium.getPlasma(114514));
        ItemStack plasmaThorium232Packet = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().THORIUM232.getPlasma(), 114514));
        ItemStack plasmaBoronPacket = ItemFluidPacket.newStack(Materials.Boron.getPlasma(114514));
        ItemStack plasmaRheniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().RHENIUM.getPlasma(), 114514));
        ItemStack plasmaBismuthPacket = ItemFluidPacket.newStack(Materials.Bismuth.getPlasma(114514));
        ItemStack plasmaIodinePacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().IODINE.getPlasma(), 114514));
        ItemStack plasmaZirconiumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().ZIRCONIUM.getPlasma(), 114514));
        ItemStack plasmaBrominePacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().BROMINE.getPlasma(), 114514));
        ItemStack plasmaXenonPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().XENON.getPlasma(), 114514));
        ItemStack plasmaHypogenPacket = ItemFluidPacket.newStack(Materials.Hydrogen.getPlasma(114514));
        ItemStack plasmaAdvancedNitinolPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.ADVANCED_NITINOL.getPlasma(), 114514));
        ItemStack plasmaChromaticGlassPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getPlasma(), 114514));
        ItemStack plasmaAstralTitaniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getPlasma(), 114514));
        ItemStack plasmaCelestialTungstenPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getPlasma(), 114514));
        ItemStack plasmaDragonBloodPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.DRAGON_METAL.getPlasma(), 114514));
        ItemStack plasmaTinPacket = ItemFluidPacket.newStack(Materials.Tin.getPlasma(114514));
        ItemStack plasmaThalliumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().THALLIUM.getPlasma(), 114514));
        ItemStack plasmaCalciumPacket = ItemFluidPacket.newStack(Materials.Calcium.getPlasma(114514));
        ItemStack plasmaTitaniumPacket = ItemFluidPacket.newStack(Materials.Titanium.getPlasma(114514));
        ItemStack plasmaFermiumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().FERMIUM.getPlasma(), 114514));
        ItemStack plasmaRutheniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().RUTHENIUM.getPlasma(), 114514));
        ItemStack plasmaSilverPacket = ItemFluidPacket.newStack(Materials.Silver.getPlasma(114514));
        ItemStack plasmaRadiumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().RADIUM.getPlasma(), 114514));
        ItemStack plasmaPlutonium238Packet = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().PLUTONIUM238.getPlasma(), 114514));
        ItemStack plasmaRunitePacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.RUNITE.getPlasma(), 114514));
        ItemStack rawStarMatterPacket = ItemFluidPacket.newStack(Materials.RawStarMatter.getFluid(114514));
        ItemStack plasmaForcePacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.FORCE.getPlasma(), 114514));
        ItemStack plasmaRhugnorPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.STANDALONE.RHUGNOR.getPlasma(), 114514));
        ItemStack plasmaZincPacket = ItemFluidPacket.newStack(Materials.Zinc.getPlasma(114514));
        ItemStack plasmaTechnetiumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().TECHNETIUM.getPlasma(), 114514));
        ItemStack plasmaNeptuniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().NEPTUNIUM.getPlasma(), 114514));
        ItemStack plasmaCaliforniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().CALIFORNIUM.getPlasma(), 114514));
        ItemStack plasmaNiobiumPacket = ItemFluidPacket.newStack(Materials.Niobium.getPlasma(114514));
        ItemStack plasmaCuriumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().CURIUM.getPlasma(), 114514));
        ItemStack plasmaProtactiniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().PROTACTINIUM.getPlasma(), 114514));
        ItemStack excitedDTRCPacket = ItemFluidPacket.newStack(Materials.ExcitedDTRC.getFluid(114514));
        ItemStack excitedDTSCFluidPacket = ItemFluidPacket.newStack(Materials.ExcitedDTSC.getFluid(114514));
        ItemStack excitedDTECFluidPacket = ItemFluidPacket.newStack(Materials.ExcitedDTEC.getFluid(114514));
        ItemStack excitedDTPCFluidPacket = ItemFluidPacket.newStack(Materials.ExcitedDTPC.getFluid(114514));
        ItemStack excitedDTCCFluidPacket = ItemFluidPacket.newStack(Materials.ExcitedDTCC.getFluid(114514));
        ItemStack plasmaRhodiumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().RHODIUM.getPlasma(), 114514));
        ItemStack plasmaNickelPacket = ItemFluidPacket.newStack(Materials.Nickel.getPlasma(114514));
        ItemStack plasmaPoloniumPacket = ItemFluidPacket
            .newStack(new FluidStack(MaterialsElements.getInstance().POLONIUM.getPlasma(), 114514));
        ItemStack dimensionallyTranscendentCrudeCatalystPacket = ItemFluidPacket
            .newStack(Materials.DTCC.getFluid(114514));
        ItemStack dimensionallyTranscendentExoticCatalystPacket = ItemFluidPacket
            .newStack(Materials.DTEC.getFluid(114514));
        ItemStack plasmaThoriumPacket = ItemFluidPacket.newStack(Materials.Thorium.getPlasma(114514));
        ItemStack stableBaryonicMatterPacket = ItemFluidPacket
            .newStack(Materials.StableBaryonicMatter.getFluid(114514));
        ItemStack dimensionallyTranscendentStellarCatalystPacket = ItemFluidPacket
            .newStack(Materials.DTSC.getFluid(114514));
        ItemStack dimensionallyTranscendentProsaicCatalystPacket = ItemFluidPacket
            .newStack(Materials.DTPC.getFluid(114514));
        ItemStack dimensionallyTranscendentResplendentCatalystPacket = ItemFluidPacket
            .newStack(Materials.DTRC.getFluid(114514));
        ItemStack plasmaIronPacket = ItemFluidPacket.newStack(Materials.Iron.getPlasma(114514));
        ItemStack[] purifiedWaterPackets = new ItemStack[8];

        for (int i = 1; i <= 8; i++) {
            Materials material = Materials.get("Grade" + i + "PurifiedWater");
            purifiedWaterPackets[i - 1] = ItemFluidPacket.newStack(material.getFluid(114514));
        }

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinitySword.get(1),
                "------AAA",
                "-----ABBA",
                "----ABCBA",
                "-DDABEBA-",
                "DBBDFBA--",
                "-DDCDA---",
                "-ADDBD---",
                "ACADBD---",
                "AA--D----",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                GTNLItemList.EnhancementCore.get(1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                ReAvaItemList.BlazeSword.get(1),
                'F',
                ReAvaItemList.CrystalSword.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityAxe.get(1),
                "---BBBB-A",
                "--BBBBDD-",
                "--BBBBDDB",
                "--B-ACBBB",
                "---AEABBB",
                "--AFA-BB-",
                "-ACA-----",
                "DDA------",
                "DD-------",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                GTNLItemList.EnhancementCore.get(1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                ReAvaItemList.BlazeAxe.get(1),
                'F',
                ReAvaItemList.CrystalAxe.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityPickaxe.get(1),
                "--BBBBBBA",
                "-BBBBBDDB",
                "-----BDDB",
                "----ACBBB",
                "---AEA-BB",
                "--AFA--BB",
                "-ACA---BB",
                "DDA----B-",
                "DD-------",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                GTNLItemList.EnhancementCore.get(1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                ReAvaItemList.BlazePickaxe.get(1),
                'F',
                ReAvaItemList.CrystalPickaxe.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityShovel.get(1),
                "------BBB",
                "-----BBBB",
                "-----BBBB",
                "----ACBB-",
                "---AEA---",
                "--AFA----",
                "-ACA-----",
                "DDA------",
                "DD-------",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                GTNLItemList.EnhancementCore.get(1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                ReAvaItemList.BlazeShovel.get(1),
                'F',
                ReAvaItemList.CrystalShovel.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityHoe.get(1),
                "-BBBBBBBA",
                "--BBBBDDB",
                "-----ADBB",
                "----ACA-B",
                "---AEA---",
                "--AFA----",
                "-ACA-----",
                "DDA------",
                "DD-------",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                GTNLItemList.EnhancementCore.get(1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                ReAvaItemList.BlazeHoe.get(1),
                'F',
                ReAvaItemList.CrystalHoe.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityBucket.get(1),
                "AA-----AA",
                "AAB---BAA",
                "ACCB-BCCA",
                "ACCB-BCCA",
                "ACCBBBCCA",
                "ACCCCCCCA",
                "AACCCCCAA",
                "-DAAAAAD-",
                "--DDDDD--",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                new ItemStack(Items.bucket, 1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.InfinityTotem.get(1),
                "---AAA---",
                "D-AAAAA-D",
                "-DABACAD-",
                "-EAAAAAE-",
                "DDDAFADDD",
                "EEAAAAAEE",
                "-DAAAAAD-",
                "D--DDD--D",
                "---DDD---",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                new ItemStack(Blocks.redstone_block, 1),
                'C',
                new ItemStack(Blocks.lapis_block, 1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'E',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'F',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.BlazeSword.get(1),
                "-------CA",
                "------CAC",
                "--B--CAC-",
                "--B-CAC--",
                "-BACAC---",
                "-BAFC----",
                "--DAABB--",
                "-D-BB----",
                "E--------",
                'A',
                GTNLItemList.BlazeCube.get(1),
                'B',
                NHItemList.LichBone.get(1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.FierySteel, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1),
                'F',
                GTNLItemList.BlazeCubeBlock.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.BlazePickaxe.get(1),
                "--AAAAABB",
                "-AAAAAABB",
                "-----CBAA",
                "----CBCAA",
                "---CBC-AA",
                "--CDC--AA",
                "-CDC---AA",
                "CDC----A-",
                "EC-------",
                'A',
                GTNLItemList.BlazeCube.get(1),
                'B',
                NHItemList.LichBone.get(1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.FierySteel, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.BlazeAxe.get(1),
                "---AAAAA-",
                "--AAAAA--",
                "--AAAAFA-",
                "--A-CBAAA",
                "---CBCAAA",
                "--CDC--AA",
                "-CDC-----",
                "CDC------",
                "EC-------",
                'A',
                GTNLItemList.BlazeCube.get(1),
                'B',
                NHItemList.LichBone.get(1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.FierySteel, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1),
                'F',
                GTNLItemList.BlazeCubeBlock.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.BlazeShovel.get(1),
                "------AA-",
                "-----AAAA",
                "-----AAAA",
                "----CBAA-",
                "---CBC---",
                "--CBC----",
                "-CDC-----",
                "CDC------",
                "EC-------",
                'A',
                GTNLItemList.BlazeCube.get(1),
                'B',
                NHItemList.LichBone.get(1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.FierySteel, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.BlazeHoe.get(1),
                "--AAAAAA-",
                "---AAAABB",
                "-----CBBA",
                "----CBCA-",
                "---CDC---",
                "--CDC----",
                "-CDC-----",
                "CDC------",
                "EC-------",
                'A',
                GTNLItemList.BlazeCube.get(1),
                'B',
                NHItemList.LichBone.get(1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.FierySteel, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                GTNLItemList.EnhancementCore.get(1),
                "---AAA---",
                "-BACCCAB-",
                "-ADEEEDA-",
                "ACEEFEECA",
                "ACEFGFECA",
                "ACEEFEECA",
                "-ADEEEDA-",
                "-BACCCAB-",
                "---AAA---",
                'A',
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Infinity, 1),
                'F',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 5),
                'G',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Endest_Pearl", 1, 0));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.CrystalSword.get(1),
                "-------AB",
                "------ABA",
                "-B--ACBA-",
                "-BCACBC--",
                "BBCCBCA--",
                "-BBCCA---",
                "--DBCC---",
                "BD-BBBB--",
                "BB--B----",
                'A',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 0),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.CrystalPickaxe.get(1),
                "-BBBBBBAD",
                "--BC-ABCA",
                "-----BBBB",
                "-----DBAB",
                "----D---B",
                "---D---CB",
                "--D----BB",
                "BD------B",
                "BB-------",
                'A',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 0),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.CrystalAxe.get(1),
                "---AAAA--",
                "--ABBBBC-",
                "--ABBBBA-",
                "--AAABBBA",
                "--A-CABBA",
                "---C--AA-",
                "--C------",
                "BC-------",
                "BB-------",
                'A',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'C',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.CrystalShovel.get(1),
                "-----CCCA",
                "----CBBBC",
                "---CBBBBC",
                "----CDBBC",
                "----DCBC-",
                "---D--C--",
                "--D------",
                "BD-------",
                "BB-------",
                'A',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 0),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.CrystalHoe.get(1),
                "-CCCCCCA-",
                "--CBBBBBA",
                "---CCCDBC",
                "-----DCBC",
                "----D--CC",
                "---D----C",
                "--D------",
                "BD-------",
                "BB-------",
                'A',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 0),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0),
                'C',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.ChronarchsClock.get(1),
                "--AAAAA--",
                "-AAAAAAA-",
                "AABBBBBAA",
                "AABCCCBAA",
                "AABCCCBAA",
                "ADBCCCBDA",
                "ADBBBBBDA",
                "-ADDDDDA-",
                "--AAAAA--",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1),
                'C',
                new ItemStack(Items.clock, 1),
                'D',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1, 0));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                GTNLItemList.InfinityDyeCell.get(1),
                "--ABCBA--",
                "-BBDEDBB-",
                "ABDDFDDBA",
                "BDDGHGDDB",
                "IJKLMNOPQ",
                "BDDGRGDDB",
                "ABDDSDDBA",
                "-BBDTDBB-",
                "--ABUBA--",
                'A',
                new ItemStack(Blocks.sand, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 1),
                'C',
                new ItemStack(Items.dye, 1, 12),
                'D',
                GTModHandler.getModItem(Mods.ThaumicBases.ID, "rainbowCactus", 1, 0),
                'E',
                new ItemStack(Items.dye, 1, 8),
                'F',
                new ItemStack(Items.dye, 1, 4),
                'G',
                ItemList.AcceleratorIV.get(1),
                'H',
                new ItemStack(Items.dye, 1, 0),
                'I',
                new ItemStack(Items.dye, 1, 15),
                'J',
                new ItemStack(Items.dye, 1, 11),
                'K',
                new ItemStack(Items.dye, 1, 7),
                'L',
                new ItemStack(Items.dye, 1, 3),
                'M',
                aeMaterials.emptyAdvancedStorageCell()
                    .maybeStack(1)
                    .orNull(),
                'N',
                new ItemStack(Items.dye, 1, 1),
                'O',
                new ItemStack(Items.dye, 1, 5),
                'P',
                new ItemStack(Items.dye, 1, 9),
                'Q',
                new ItemStack(Items.dye, 1, 13),
                'R',
                new ItemStack(Items.dye, 1, 2),
                'S',
                new ItemStack(Items.dye, 1, 6),
                'T',
                new ItemStack(Items.dye, 1, 10),
                'U',
                new ItemStack(Items.dye, 1, 14));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                GTNLItemList.InfinityDyeFluidCell.get(1),
                "--ABCBA--",
                "--DEFGH--",
                "AIJJKJJLA",
                "BMJJNJJOB",
                "PQRSTUVWX",
                "BYJJZJJ0B",
                "A1JJ2JJ3A",
                "--45678--",
                "--AB9BA--",
                'A',
                GTModHandler.getModItem(Mods.Botania.ID, "bifrostPerm", 1, 0),
                'B',
                ItemList.Field_Generator_EV.get(1),
                'C',
                new ItemStack(Items.dye, 1, 12),
                'D',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.HSSE, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Soularium, 1),
                'F',
                new ItemStack(Items.dye, 1, 8),
                'G',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Cobalt, 1),
                'H',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MelodicAlloy, 1),
                'I',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Rubidium, 1),
                'J',
                GregtechItemList.Hatch_Reservoir.get(1),
                'K',
                new ItemStack(Items.dye, 1, 4),
                'L',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.EnderiumBase, 1),
                'M',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tungsten, 1),
                'N',
                new ItemStack(Items.dye, 1, 0),
                'O',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Iridium, 1),
                'P',
                new ItemStack(Items.dye, 1, 15),
                'Q',
                new ItemStack(Items.dye, 1, 11),
                'R',
                new ItemStack(Items.dye, 1, 7),
                'S',
                new ItemStack(Items.dye, 1, 3),
                'T',
                GTModHandler.getModItem(Mods.AE2FluidCraft.ID, "fluid_storage_housing", 1, 3),
                'U',
                new ItemStack(Items.dye, 1, 1),
                'V',
                new ItemStack(Items.dye, 1, 5),
                'W',
                new ItemStack(Items.dye, 1, 9),
                'X',
                new ItemStack(Items.dye, 1, 13),
                'Y',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 1),
                'Z',
                new ItemStack(Items.dye, 1, 2),
                '0',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.ElectricalSteel, 1),
                '1',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.EnergeticAlloy, 1),
                '2',
                new ItemStack(Items.dye, 1, 6),
                '3',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Europium, 1),
                '4',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CrystallinePinkSlime, 1),
                '5',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CallistoIce, 1),
                '6',
                new ItemStack(Items.dye, 1, 10),
                '7',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Gold, 1),
                '8',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.VibrantAlloy, 1),
                '9',
                new ItemStack(Items.dye, 1, 14));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                ReAvaItemList.ExtremeAnvil.get(1),
                "AAAAAAAAA",
                "ABBBBBBBA",
                "--BCCCB--",
                "--CDDDC--",
                "--CDEDC--",
                "--CDDDC--",
                "-ABCCCBA-",
                "-ABBBBBA-",
                "-AAAAAAA-",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1),
                'C',
                new ItemStack(Blocks.anvil, 1),
                'D',
                GTNLItemList.BlazeCubeBlock.get(1),
                'E',
                GTNLItemList.EnhancementCore.get(1));

        ExtremeCraftingManager.getInstance()
            .addExtremeShapedOreRecipe(
                GTNLItemList.InfinityStoneCell.get(1),
                "--ABCBA--",
                "-DEFGFED-",
                "AHFFIFFHA",
                "JFFFKFFFJ",
                "CGIKLKIGC",
                "JFFFKFFFJ",
                "AHFFIFFHA",
                "-DEFGFED-",
                "--ABCBA--",
                'A',
                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 1),
                'B',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Naquadah, 1),
                'C',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Carbon, 1),
                'D',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Vanadium, 1),
                'E',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Bedrockium, 1),
                'F',
                GTModHandler.getModItem(Mods.ExtraUtilities.ID, "cobblestone_compressed", 1, 6),
                'G',
                ItemList.Field_Generator_UV.get(1),
                'H',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tungsten, 1),
                'I',
                GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 5),
                'J',
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NiobiumTitanium, 1),
                'K',
                GTNLItemList.LargeRockCrusher.get(1),
                'L',
                aeMaterials.emptyAdvancedStorageCell()
                    .maybeStack(1)
                    .orNull());

        if (Mods.EtFuturumRequiem.isModLoaded()) {
            loadEtFuturumRecipe();
        }
    }

    @Optional.Method(modid = "etfuturum")
    public static void loadEtFuturumRecipe() {
        if (ConfigMixins.enableElytra) {
            ExtremeCraftingManager.getInstance()
                .addExtremeShapedOreRecipe(
                    ReAvaItemList.InfinityElytra.get(1),
                    "--AA-AA--",
                    "-BAACAAB-",
                    "BDBAEABDB",
                    "DDDB-BDDD",
                    "DDDD-DDDD",
                    "DDDD-DDDD",
                    "DDDD-DDDD",
                    "DDD---DDD",
                    "-D-----D-",
                    'A',
                    GTOreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1),
                    'B',
                    GTModHandler.getModItem(Mods.Avaritia.ID, "Crystal_Matrix", 1),
                    'C',
                    GTModHandler.getModItem(Mods.Avaritia.ID, "Endest_Pearl", 1),
                    'D',
                    GTModHandler.getModItem(Mods.Avaritia.ID, "Resource", 1, 1),
                    'E',
                    GTModHandler.getModItem(Mods.EtFuturumRequiem.ID, "elytra", 1));
        }
    }
}
