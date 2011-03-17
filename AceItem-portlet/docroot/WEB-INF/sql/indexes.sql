create index IX_9D82ED2A on Ace_AceItem (groupId);

create index IX_D487E22E on Ace_AceSector (aceItemId);
create index IX_D92D74B7 on Ace_AceSector (groupId);

create index IX_E13A55B8 on Ace_Items_ClimateImpacts (aceItemId);
create index IX_E91E07E on Ace_Items_ClimateImpacts (impactId);

create index IX_AFFBA8E9 on Ace_Items_Elements (aceItemId);
create index IX_2C0E86AF on Ace_Items_Elements (elementId);

create index IX_C09721E9 on Ace_Items_Sectors (aceItemId);
create index IX_A902544D on Ace_Items_Sectors (sectorId);