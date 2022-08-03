module.exports = (sequelize, { DataTypes }) => {
    const eyeReport = sequelize.define(
        "eyeReport",
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
            re_dist_sph: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            re_dist_cyl: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            re_near_sph: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            re_near_cyl: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            le_dist_sph: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            le_dist_cyl: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            le_near_sph: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            le_near_cyl: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            use: {
                type: DataTypes.STRING,
                allowNull: false,
            },
        },
        {
            sequelize,
            tableName: 'eyeReport',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return eyeReport;
};