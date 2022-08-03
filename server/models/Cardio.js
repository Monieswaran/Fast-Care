module.exports = (sequelize, { DataTypes }) => {
    const CardioReport = sequelize.define(
        "CardioReport",
        {
            uid: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            name: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            age: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            gender: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            regDate: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            weight: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            height: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            riskfactor: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            baseBp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            peakBp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            baseHp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            peakHp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            bp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            hp: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            medications: {
                type: DataTypes.STRING
            },
        },
        {
            sequelize,
            tableName: 'cardioReport',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return CardioReport;
};