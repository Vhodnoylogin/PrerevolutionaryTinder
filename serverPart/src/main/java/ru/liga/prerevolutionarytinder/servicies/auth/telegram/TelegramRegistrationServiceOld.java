package ru.liga.prerevolutionarytinder.servicies.auth.telegram;

//@Service
//@Qualifier("telegramRegistrationService")
//public class TelegramRegistrationServiceOld implements RegistrationService<TelegramRegistrationInfo, TelegramAuthEntity> {
//    private final TelegramRegistrationRepository registrationRepository;
//    private final TelegramAuthMapper telegramAuthMapper;
//
//
//    @Autowired
//    public TelegramRegistrationServiceOld(TelegramRegistrationRepository registrationRepository, TelegramAuthMapper telegramAuthMapper) {
//        this.registrationRepository = registrationRepository;
//        this.telegramAuthMapper = telegramAuthMapper;
//    }
//
//    @Override
//    public TelegramAuthEntity create(TelegramRegistrationInfo authPrincipleInfo) {
//        var telegramAuthEntity = telegramAuthMapper.mapToEntity(authPrincipleInfo);
//        return registrationRepository.save(telegramAuthEntity);
//    }
//
//    @Override
//    public SourceType getApplicableType() {
//        return SourceType.TELEGRAM;
//    }
//}
